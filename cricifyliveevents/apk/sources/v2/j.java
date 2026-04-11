package v2;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import ua.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Spatializer$OnSpatializerStateChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f13105a;

    public j(o oVar) {
        this.f13105a = oVar;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z10) {
        x0 x0Var = o.f13112k;
        this.f13105a.f();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z10) {
        x0 x0Var = o.f13112k;
        this.f13105a.f();
    }
}
