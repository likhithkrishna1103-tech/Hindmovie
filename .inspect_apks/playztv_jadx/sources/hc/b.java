package hc;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6029u;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6029u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = LandscapeActivity.f3596a0;
                break;
            case 1:
                int i10 = MainActivity.F0;
                break;
        }
    }

    private final void a(View view) {
    }
}
