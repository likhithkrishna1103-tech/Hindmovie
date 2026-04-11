package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r0 f786c = new r0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f788b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f787a = new e0();

    public final u0 a(Class cls) {
        u0 u0VarW;
        Class cls2;
        x.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f788b;
        u0 u0Var = (u0) concurrentHashMap.get(cls);
        if (u0Var != null) {
            return u0Var;
        }
        e0 e0Var = this.f787a;
        e0Var.getClass();
        Class cls3 = v0.f800a;
        if (!v.class.isAssignableFrom(cls) && (cls2 = v0.f800a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        t0 t0VarA = ((d0) e0Var.f697a).a(cls);
        int i = t0VarA.f799d;
        a aVar = t0VarA.f796a;
        if ((i & 2) == 2) {
            if (v.class.isAssignableFrom(cls)) {
                u0VarW = new n0(v0.f802c, p.f764a, aVar);
            } else {
                c1 c1Var = v0.f801b;
                o oVar = p.f765b;
                if (oVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                u0VarW = new n0(c1Var, oVar, aVar);
            }
        } else if (v.class.isAssignableFrom(cls)) {
            o oVar2 = null;
            o0 o0Var = p0.f767b;
            b0 b0Var = c0.f689b;
            c1 c1Var2 = v0.f802c;
            if (y.e.c(t0VarA.a()) != 1) {
                oVar2 = p.f764a;
            }
            o oVar3 = oVar2;
            i0 i0Var = j0.f732b;
            if (!(t0VarA instanceof t0)) {
                int[] iArr = m0.f746n;
                t0VarA.getClass();
                throw new ClassCastException();
            }
            u0VarW = m0.w(t0VarA, o0Var, b0Var, c1Var2, oVar3, i0Var);
        } else {
            o oVar4 = null;
            o0 o0Var2 = p0.f766a;
            b0 b0Var2 = c0.f688a;
            c1 c1Var3 = v0.f801b;
            if (y.e.c(t0VarA.a()) != 1 && (oVar4 = p.f765b) == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            o oVar5 = oVar4;
            i0 i0Var2 = j0.f731a;
            if (!(t0VarA instanceof t0)) {
                int[] iArr2 = m0.f746n;
                t0VarA.getClass();
                throw new ClassCastException();
            }
            u0VarW = m0.w(t0VarA, o0Var2, b0Var2, c1Var3, oVar5, i0Var2);
        }
        u0 u0Var2 = (u0) concurrentHashMap.putIfAbsent(cls, u0VarW);
        return u0Var2 != null ? u0Var2 : u0VarW;
    }
}
