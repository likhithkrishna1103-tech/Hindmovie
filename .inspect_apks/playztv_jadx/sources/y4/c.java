package y4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public interface c extends AutoCloseable {
    boolean O();

    boolean W();

    void b(int i);

    int getColumnCount();

    String getColumnName(int i);

    long getLong(int i);

    void i(String str, int i);

    boolean isNull(int i);

    String j(int i);

    void k(long j5);

    void reset();
}
