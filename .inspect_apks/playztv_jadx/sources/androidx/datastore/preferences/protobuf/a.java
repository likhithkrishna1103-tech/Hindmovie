package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    protected int memoizedHashCode;

    public abstract int a();

    public final int b(b1 b1Var) {
        w wVar = (w) this;
        int i = wVar.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iD = b1Var.d(this);
        wVar.memoizedSerializedSize = iD;
        return iD;
    }

    public abstract void c(k kVar);
}
