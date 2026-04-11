package f9;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w4 f4476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f4477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a2 f4478d;

    public /* synthetic */ x1(a2 a2Var, w4 w4Var, Bundle bundle, int i) {
        this.f4475a = i;
        this.f4476b = w4Var;
        this.f4477c = bundle;
        this.f4478d = a2Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        switch (this.f4475a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a2 a2Var = this.f4478d;
                a2Var.f4001d.w();
                return a2Var.f4001d.Y(this.f4477c, this.f4476b);
            default:
                a2 a2Var2 = this.f4478d;
                a2Var2.f4001d.w();
                return a2Var2.f4001d.Y(this.f4477c, this.f4476b);
        }
    }
}
