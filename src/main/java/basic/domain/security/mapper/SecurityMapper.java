package basic.domain.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import basic.domain.sign.dto.UserDTO;

@Mapper
public interface SecurityMapper {
	public UserDTO getOwninfo(String id);
}
