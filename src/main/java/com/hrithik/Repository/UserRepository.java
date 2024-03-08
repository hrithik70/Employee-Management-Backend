package com.hrithik.Repository;

import com.hrithik.DataObjects.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDO,Long> {
}
