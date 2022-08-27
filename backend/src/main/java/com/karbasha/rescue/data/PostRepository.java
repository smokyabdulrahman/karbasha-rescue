package com.karbasha.rescue.data;

import com.karbasha.rescue.data.entities.post.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
