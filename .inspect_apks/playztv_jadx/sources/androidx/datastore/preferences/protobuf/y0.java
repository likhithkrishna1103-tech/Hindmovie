package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0 f1144c = new y0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f1146b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f1145a = new k0();

    public final b1 a(Class cls) {
        b1 b1VarW;
        Class cls2;
        z.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f1146b;
        b1 b1Var = (b1) concurrentHashMap.get(cls);
        if (b1Var != null) {
            return b1Var;
        }
        k0 k0Var = this.f1145a;
        k0Var.getClass();
        Class cls3 = c1.f1026a;
        if (!w.class.isAssignableFrom(cls) && (cls2 = c1.f1026a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        a1 a1VarA = ((j0) k0Var.f1082a).a(cls);
        int i = a1VarA.f1004d;
        a aVar = a1VarA.f1001a;
        if ((i & 2) == 2) {
            if (w.class.isAssignableFrom(cls)) {
                b1VarW = new t0(c1.f1029d, p.f1095a, aVar);
            } else {
                k1 k1Var = c1.f1027b;
                o oVar = p.f1096b;
                if (oVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                b1VarW = new t0(k1Var, oVar, aVar);
            }
        } else if (w.class.isAssignableFrom(cls)) {
            b1VarW = (a1VarA.f1004d & 1) == 1 ? s0.w(a1VarA, v0.f1142b, h0.f1059b, c1.f1029d, p.f1095a, p0.f1098b) : s0.w(a1VarA, v0.f1142b, h0.f1059b, c1.f1029d, null, p0.f1098b);
        } else if ((a1VarA.f1004d & 1) == 1) {
            u0 u0Var = v0.f1141a;
            f0 f0Var = h0.f1058a;
            k1 k1Var2 = c1.f1027b;
            o oVar2 = p.f1096b;
            if (oVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            b1VarW = s0.w(a1VarA, u0Var, f0Var, k1Var2, oVar2, p0.f1097a);
        } else {
            b1VarW = s0.w(a1VarA, v0.f1141a, h0.f1058a, c1.f1028c, null, p0.f1097a);
        }
        b1 b1Var2 = (b1) concurrentHashMap.putIfAbsent(cls, b1VarW);
        return b1Var2 != null ? b1Var2 : b1VarW;
    }
}
