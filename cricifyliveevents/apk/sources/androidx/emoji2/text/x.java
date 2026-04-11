package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0.d f894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jb.b f895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f896d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f897e;
    public ThreadPoolExecutor f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.c f899h;

    public x(Context context, q0.d dVar) {
        com.bumptech.glide.f.f(context, "Context cannot be null");
        this.f893a = context.getApplicationContext();
        this.f894b = dVar;
        this.f895c = y.f900d;
    }

    @Override // androidx.emoji2.text.l
    public final void a(com.bumptech.glide.c cVar) {
        synchronized (this.f896d) {
            this.f899h = cVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f896d) {
            try {
                this.f899h = null;
                Handler handler = this.f897e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f897e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f898g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f = null;
                this.f898g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.f896d) {
            try {
                if (this.f899h == null) {
                    return;
                }
                if (this.f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(0, "emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f898g = threadPoolExecutor;
                    this.f = threadPoolExecutor;
                }
                this.f.execute(new w(0, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final q0.i d() {
        try {
            jb.b bVar = this.f895c;
            Context context = this.f893a;
            q0.d dVar = this.f894b;
            bVar.getClass();
            Object[] objArr = {dVar};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            h4.f fVarA = q0.c.a(context, Collections.unmodifiableList(arrayList));
            int i = fVarA.f5623a;
            if (i != 0) {
                throw new RuntimeException(l0.e.h(i, "fetchFonts failed (", ")"));
            }
            q0.i[] iVarArr = (q0.i[]) fVarA.f5624b.get(0);
            if (iVarArr == null || iVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return iVarArr[0];
        } catch (PackageManager.NameNotFoundException e9) {
            throw new RuntimeException("provider not found", e9);
        }
    }
}
