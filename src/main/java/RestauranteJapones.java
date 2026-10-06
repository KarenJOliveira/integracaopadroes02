public class RestauranteJapones implements RestauranteFactory{
    @Override
    public Prato criarPrato() {
        return new Sushi();
    }
}
