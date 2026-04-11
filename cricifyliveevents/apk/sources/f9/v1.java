package f9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4446v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f4447w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f4448x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f4449y;

    public /* synthetic */ v1() {
        this.f4446v = 12;
    }

    private final void a() {
        int i;
        j9.p pVarE;
        k8.a aVar = (k8.a) this.f4447w;
        Intent intent = aVar.f7244v;
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("message_id");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            pVarE = vf.g.A(null);
        } else {
            Bundle bundle = new Bundle();
            Intent intent2 = aVar.f7244v;
            String stringExtra2 = intent2.getStringExtra("google.message_id");
            if (stringExtra2 == null) {
                stringExtra2 = intent2.getStringExtra("message_id");
            }
            bundle.putString("google.message_id", stringExtra2);
            Intent intent3 = aVar.f7244v;
            Integer numValueOf = intent3.hasExtra("google.product_id") ? Integer.valueOf(intent3.getIntExtra("google.product_id", 0)) : null;
            if (numValueOf != null) {
                bundle.putInt("google.product_id", numValueOf.intValue());
            }
            Context context = (Context) this.f4449y;
            bundle.putBoolean("supports_message_handled", true);
            k8.m mVarD = k8.m.d(context);
            synchronized (mVarD) {
                i = mVarD.f7279v;
                mVarD.f7279v = i + 1;
            }
            pVarE = mVarD.e(new k8.l(i, 2, bundle, 0));
        }
        pVarE.b(k8.h.f7260w, new pc.c((CountDownLatch) this.f4448x));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0535  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.v1.run():void");
    }

    public /* synthetic */ v1(int i, Object obj, Object obj2, Object obj3, boolean z10) {
        this.f4446v = i;
        this.f4449y = obj;
        this.f4447w = obj2;
        this.f4448x = obj3;
    }

    public /* synthetic */ v1(Object obj, w4 w4Var, Object obj2, int i) {
        this.f4446v = i;
        this.f4448x = obj;
        this.f4447w = w4Var;
        this.f4449y = obj2;
    }

    public /* synthetic */ v1(Object obj, Object obj2, Object obj3, int i) {
        this.f4446v = i;
        this.f4449y = obj2;
        this.f4447w = obj3;
        this.f4448x = obj;
    }

    public v1(t3 t3Var, AtomicReference atomicReference, w4 w4Var) {
        this.f4446v = 5;
        this.f4449y = atomicReference;
        this.f4447w = w4Var;
        Objects.requireNonNull(t3Var);
        this.f4448x = t3Var;
    }
}
