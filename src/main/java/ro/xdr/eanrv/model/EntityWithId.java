package ro.xdr.eanrv.model;

/**
 * Created by rares.urdea on 30.10.2014.
 */
public interface EntityWithId<I> {

    public I getId();

    public void setId(I id);

}
