package hr.tvz.pripeljas.user;

import java.util.Optional;

public interface UserService
{
    Optional<UserDTO> findByUsername (String username);
}
