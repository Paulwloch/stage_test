package mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mybatis.model.Player;


@Mapper
public interface PlayerMapper {

	@Select("select * from player")
	List<Player> findAll();
	
	@Select("select * from player where club = #{club}")
	List<Player>findAllClub(String club);
	
	@Select("select * from player where id = #{id}")
	Player findById(int i);
	
	@Select("select * from player where name = #{name}")
	Player findByName(String s);
	
	@Insert("insert into player(name,nationality,club) values (#{name},#{nationality},#{club}) ")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insert(Player player);
	
	@Update("update player set club = #{club} where name = #{name}")
	void updatePlayer(Player player);
	
	@Delete("delete from player where id= #{id}" )
	void deleteById(int i);
}
