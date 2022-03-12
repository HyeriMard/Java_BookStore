package WebShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import WebShop.Enity.MapperSlides;
import WebShop.Enity.Slides;

@Repository
public class SlidesDao extends BaseDao{

	public List<Slides> GetDataSlide(){
		List<Slides> list = new ArrayList<Slides>();
		String sql = "SELECT * FROM slides";
		list = jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
}
