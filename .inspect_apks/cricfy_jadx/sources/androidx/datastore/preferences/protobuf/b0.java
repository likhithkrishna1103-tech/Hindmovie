package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public static w a(long j4, Object obj) {
        w wVar = (w) h1.f718c.h(j4, obj);
        if (((b) wVar).f680v) {
            return wVar;
        }
        s0 s0Var = (s0) wVar;
        int i = s0Var.f793x;
        s0 s0VarC = s0Var.c(i == 0 ? 10 : i * 2);
        h1.o(obj, j4, s0VarC);
        return s0VarC;
    }
}
