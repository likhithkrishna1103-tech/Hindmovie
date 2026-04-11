package h4;

import android.content.Context;
import android.media.session.MediaController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaController f5824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5825b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5826c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f5827d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f5828e;

    public l(Context context, y yVar) {
        this.f5828e = yVar;
        MediaController mediaController = new MediaController(context, yVar.f5863v);
        this.f5824a = mediaController;
        if (yVar.a() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new j(this));
        }
    }

    public final void a() {
        if (this.f5828e.a() == null) {
            return;
        }
        ArrayList arrayList = this.f5826c;
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            arrayList.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            this.f5827d.put(null, new k());
            throw null;
        }
    }
}
