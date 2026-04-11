package x7;

import android.content.Context;
import androidx.emoji2.text.w;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile j f14449e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g8.a f14450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g8.a f14451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c8.d f14452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d8.j f14453d;

    public p(g8.a aVar, g8.a aVar2, c8.d dVar, d8.j jVar, nc.p pVar) {
        this.f14450a = aVar;
        this.f14451b = aVar2;
        this.f14452c = dVar;
        this.f14453d = jVar;
        ((Executor) pVar.f9069a).execute(new w(5, pVar));
    }

    public static p a() {
        j jVar = f14449e;
        if (jVar != null) {
            return (p) jVar.A.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f14449e == null) {
            synchronized (p.class) {
                try {
                    if (f14449e == null) {
                        androidx.emoji2.text.p pVar = new androidx.emoji2.text.p();
                        context.getClass();
                        pVar.f877a = context;
                        f14449e = pVar.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final o c(k kVar) {
        byte[] bytes;
        Set setUnmodifiableSet = kVar != null ? Collections.unmodifiableSet(v7.a.f13497d) : Collections.singleton(new u7.c("proto"));
        l7.a aVarA = i.a();
        kVar.getClass();
        aVarA.f7866w = "cct";
        v7.a aVar = (v7.a) kVar;
        String str = aVar.f13499a;
        String str2 = aVar.f13500b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        aVarA.f7867x = bytes;
        return new o(setUnmodifiableSet, aVarA.m(), this);
    }
}
