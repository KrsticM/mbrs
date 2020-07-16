package generated.mapper;

public interface Mapper <Entity, DTO>{
	public DTO fullConversion(Entity entity);
	public DTO simpleConversion(Entity entity);
}
