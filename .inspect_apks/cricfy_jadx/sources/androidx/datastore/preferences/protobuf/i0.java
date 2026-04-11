package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {
    public static h0 a(Object obj, Object obj2) {
        h0 h0VarB = (h0) obj;
        h0 h0Var = (h0) obj2;
        if (!h0Var.isEmpty()) {
            if (!h0VarB.f715v) {
                h0VarB = h0VarB.b();
            }
            h0VarB.a();
            if (!h0Var.isEmpty()) {
                h0VarB.putAll(h0Var);
            }
        }
        return h0VarB;
    }
}
