package h4;

import android.media.session.MediaSessionManager;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class u extends t {
    @Override // h4.t
    public final b0 c() {
        MediaSessionManager.RemoteUserInfo currentControllerInfo = this.f5847a.getCurrentControllerInfo();
        b0 b0Var = new b0();
        String packageName = currentControllerInfo.getPackageName();
        if (packageName == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(packageName)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        b0Var.f5792a = new c0(currentControllerInfo.getPid(), currentControllerInfo.getUid(), currentControllerInfo.getPackageName());
        return b0Var;
    }

    @Override // h4.t
    public final void d(b0 b0Var) {
    }
}
