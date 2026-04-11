package c5;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface c extends AutoCloseable {
    void E(int i, String str);

    boolean L();

    boolean V();

    void b(int i);

    void e(int i, long j4);

    void f();

    int getColumnCount();

    String getColumnName(int i);

    long getLong(int i);

    boolean isNull(int i);

    String j(int i);

    void reset();
}
