package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import c5.b;
import h.l;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import k8.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // c5.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // c5.b
    public final Object b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new b0(20);
        }
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: o4.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j5) {
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new l(applicationContext, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new b0(20);
    }
}
