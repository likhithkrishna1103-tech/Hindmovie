package ta;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements h {
    public abstract boolean a(char c9);

    @Override // ta.h
    public final boolean apply(Object obj) {
        return a(((Character) obj).charValue());
    }
}
