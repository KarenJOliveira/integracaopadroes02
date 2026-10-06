public class RestauranteItaliano implements RestauranteFactory{
    @Override
    public Prato criarPrato() {
        return new Pizza();
    }
}
