package com.demo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccTimebucketRepo extends CassandraRepository<AccTimebucket, AccTimebucketKey> {

}
