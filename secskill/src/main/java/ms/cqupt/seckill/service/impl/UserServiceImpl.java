package ms.cqupt.seckill.service.impl;

import ms.cqupt.seckill.pojo.User;
import ms.cqupt.seckill.mapper.UserMapper;
import ms.cqupt.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author @Climber
 * @since 2021-09-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
