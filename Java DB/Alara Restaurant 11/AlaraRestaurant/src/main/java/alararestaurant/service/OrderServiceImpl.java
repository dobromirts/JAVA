package alararestaurant.service;
import alararestaurant.domain.dtos.xmlDtos.ItemDto;
import alararestaurant.domain.dtos.xmlDtos.ItemRootDto;
import alararestaurant.domain.dtos.xmlDtos.OrderDto;
import alararestaurant.domain.dtos.xmlDtos.OrderRootDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.repository.OrderItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final String XML_ORDERS_FILE_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\Alara Restaurant 11\\AlaraRestaurant\\src\\main\\resources\\files\\orders.xml";

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final EmployeeRepository employeeRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, FileUtil fileUtil, ValidationUtil validationUtil, EmployeeRepository employeeRepository, ItemRepository itemRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return this.fileUtil.readFile(XML_ORDERS_FILE_PATH);
    }

    @Override
    public String importOrders() throws JAXBException {
        StringBuilder sb=new StringBuilder();

        JAXBContext context= JAXBContext.newInstance(OrderRootDto.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        OrderRootDto orderRootDto= (OrderRootDto) unmarshaller.unmarshal(new File("D:\\JavaDB Advanced-Hibernate,Spring\\Alara Restaurant 11\\AlaraRestaurant\\src\\main\\resources\\files\\orders.xml"));

        for (OrderDto orderDto : orderRootDto.getOrderDtos()) {
            Order order=this.modelMapper.map(orderDto,Order.class);

            Employee employee = this.employeeRepository.findByName(orderDto.getEmployee());
            if (!this.validationUtil.isValid(order) || employee == null) {
                sb.append("Invalid data format.").append(System.lineSeparator());

                continue;
            }
            order.setEmployee(employee);

            List<OrderItem> itemList = new ArrayList<>();
            for (ItemRootDto item : orderDto.getItemRootDtos()) {
                for (ItemDto itemDto : item.getItemDtos()) {
                    if (this.itemRepository.findByName(itemDto.getName()) == null) {
                        continue;
                    }
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(order);
                    orderItem.setItem(this.itemRepository.findByName(itemDto.getName()));
                    orderItem.setQuantity(itemDto.getQuantity());
                    itemList.add(orderItem);

                    this.orderItemRepository.saveAndFlush(orderItem);
                }
            }
            order.setOrderItems(itemList);
            this.orderRepository.saveAndFlush(order);
            sb.append(String.format("Order for %s on %s added", orderDto.getCustomer(),
                    orderDto.getDateTime())).append(System.lineSeparator());
        }



        return sb.toString().trim();
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        StringBuilder sb=new StringBuilder();

        List<Order>orders=this.orderRepository.findAllOrderFinishedBy();
        for (Order order : orders) {
            sb.append(String.format("Name: %s", order.getEmployee().getName())).append(System.lineSeparator())
                    .append("Orders: ").append(System.lineSeparator())
                    .append(String.format("  Customer: %s", order.getCustomer())).append(System.lineSeparator())
                    .append("  Items:").append(System.lineSeparator());
            for (OrderItem orderItem : order.getOrderItems()) {
                sb.append(String.format("\tName: %s", orderItem.getItem().getName())).append(System.lineSeparator())
                        .append(String.format("\tPrice: %s", orderItem.getItem().getPrice())).append(System.lineSeparator())
                        .append(String.format("\tQuantity: %d", orderItem.getQuantity())).append(System.lineSeparator());
                sb.append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }
}
