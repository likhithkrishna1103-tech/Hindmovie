package c7;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile l f2581e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.a f2582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l7.a f2583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h7.b f2584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.s f2585d;

    public t(l7.a aVar, l7.a aVar2, h7.b bVar, b7.s sVar, ub.o oVar) {
        this.f2582a = aVar;
        this.f2583b = aVar2;
        this.f2584c = bVar;
        this.f2585d = sVar;
        ((Executor) oVar.f12868v).execute(new a2.a(23, oVar));
    }

    public static t a() {
        l lVar = f2581e;
        if (lVar != null) {
            return (t) lVar.f2569z.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f2581e == null) {
            synchronized (t.class) {
                try {
                    if (f2581e == null) {
                        k kVar = new k();
                        context.getClass();
                        kVar.f2563u = context;
                        f2581e = kVar.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final s c(m mVar) {
        byte[] bytes;
        Set setUnmodifiableSet = mVar != null ? Collections.unmodifiableSet(a7.a.f612d) : Collections.singleton(new z6.c("proto"));
        a7.b bVarA = j.a();
        mVar.getClass();
        bVarA.f620x = "cct";
        a7.a aVar = (a7.a) mVar;
        String str = aVar.f614a;
        String str2 = aVar.f615b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        bVarA.f618v = bytes;
        return new s(setUnmodifiableSet, bVarA.k(), this);
    }
}
