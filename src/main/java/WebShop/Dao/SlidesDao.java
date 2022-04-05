package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Dto.Slides;
import WebShop.Enity.MapperSlides;

@Repository
public class SlidesDao extends BaseDao{

	public List<Slides> GetDataSlide(){
		List<Slides> list = new ArrayList<Slides>();
		String sql = "SELECT * FROM slides";
		list = jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
}
