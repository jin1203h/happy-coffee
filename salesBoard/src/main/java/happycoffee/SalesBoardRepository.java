package happycoffee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesBoardRepository extends CrudRepository<SalesBoard, Long> {


}