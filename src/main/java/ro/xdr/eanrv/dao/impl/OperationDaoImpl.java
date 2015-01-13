package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.xdr.eanrv.dao.OperationDao;
import ro.xdr.eanrv.model.Operation;


@Repository
@Transactional
public class OperationDaoImpl extends AbstractEntityDaoImpl<Operation, Long> implements OperationDao {
}
