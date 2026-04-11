package l4;

import android.content.Context;
import android.media.session.MediaController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaController f7741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7742b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7743c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f7744d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0 f7745e;

    public m(Context context, b0 b0Var) {
        this.f7745e = b0Var;
        MediaController mediaController = new MediaController(context, b0Var.f7701w);
        this.f7741a = mediaController;
        if (b0Var.a() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new k(this));
        }
    }

    public final void a() {
        if (this.f7745e.a() == null) {
            return;
        }
        ArrayList arrayList = this.f7743c;
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            arrayList.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            this.f7744d.put(null, new l());
            throw null;
        }
    }
}
