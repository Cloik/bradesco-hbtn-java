
import java.util.HashMap;
import java.util.Map;

public abstract class Armazem<T> implements Armazenavel<T> {

    protected Map<String,T> inventario = new HashMap<>();
}
