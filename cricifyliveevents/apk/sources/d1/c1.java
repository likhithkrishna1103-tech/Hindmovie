package d1;

import android.os.FileObserver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends FileObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3214b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f3215c = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f3216a;

    public c1(String str) {
        super(str, 128);
        this.f3216a = new CopyOnWriteArrayList();
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        Iterator it = this.f3216a.iterator();
        while (it.hasNext()) {
            ((fe.l) it.next()).a(str);
        }
    }
}
