package x4;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import vb.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x3.a f14324c = new x3.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f14325d = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f14326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14327b;

    public a(String str, boolean z10) {
        ReentrantLock reentrantLock;
        synchronized (f14324c) {
            try {
                LinkedHashMap linkedHashMap = f14325d;
                Object reentrantLock2 = linkedHashMap.get(str);
                if (reentrantLock2 == null) {
                    reentrantLock2 = new ReentrantLock();
                    linkedHashMap.put(str, reentrantLock2);
                }
                reentrantLock = (ReentrantLock) reentrantLock2;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f14326a = reentrantLock;
        this.f14327b = z10 ? new b(str) : null;
    }
}
