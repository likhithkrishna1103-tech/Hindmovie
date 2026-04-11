package androidx.emoji2.text;

import android.content.Context;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f877a;

    @Override // androidx.emoji2.text.l
    public void a(com.bumptech.glide.c cVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(0, "EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new n(this, cVar, threadPoolExecutor, 0));
    }

    public x7.j b() {
        Context context = this.f877a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        x7.j jVar = new x7.j();
        jVar.f14437v = z7.a.a(x7.m.f14444a);
        u0.d dVar = new u0.d(context);
        jVar.f14438w = dVar;
        jVar.f14439x = z7.a.a(new vb.b(11, dVar, new kf.i(28, dVar), false));
        u0.d dVar2 = jVar.f14438w;
        jVar.f14440y = new p6.c(9, dVar2);
        qd.a aVarA = z7.a.a(new l4.c0(15, jVar.f14440y, z7.a.a(new e8.e(dVar2, 0))));
        jVar.f14441z = aVarA;
        o8.j jVar2 = new o8.j(5);
        u0.d dVar3 = jVar.f14438w;
        v vVar = new v(dVar3, aVarA, jVar2, 4);
        qd.a aVar = jVar.f14437v;
        qd.a aVar2 = jVar.f14439x;
        jVar.A = z7.a.a(new l7.a(new dd.c(aVar, aVar2, vVar, aVarA, aVarA, 1), new tb.c(dVar3, aVar2, aVarA, vVar, aVar, aVarA, aVarA), new b6.f(aVar, aVarA, vVar, aVarA, 6), 25));
        return jVar;
    }
}
