package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import f9.b0;
import h5.b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // h5.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // h5.b
    public final Object b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new b0(24);
        }
        Choreographer.getInstance().postFrameCallback(new k1.b(this, context.getApplicationContext()));
        return new b0(24);
    }
}
