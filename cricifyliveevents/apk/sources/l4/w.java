package l4;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSession f7765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f7766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f7767c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f7769e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k0 f7770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f7771h;
    public r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u f7774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e0 f7775m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7768d = new Object();
    public final RemoteCallbackList f = new RemoteCallbackList();

    public w(Context context, String str, Bundle bundle) {
        MediaSession mediaSessionA = a(context, str, bundle);
        this.f7765a = mediaSessionA;
        v vVar = new v(this);
        this.f7766b = vVar;
        this.f7767c = new b0(mediaSessionA.getSessionToken(), vVar);
        this.f7769e = bundle;
        mediaSessionA.setFlags(3);
    }

    public MediaSession a(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str);
    }

    public final u b() {
        u uVar;
        synchronized (this.f7768d) {
            uVar = this.f7774l;
        }
        return uVar;
    }

    public e0 c() {
        e0 e0Var;
        synchronized (this.f7768d) {
            e0Var = this.f7775m;
        }
        return e0Var;
    }

    public void d(e0 e0Var) {
        synchronized (this.f7768d) {
            this.f7775m = e0Var;
        }
    }
}
