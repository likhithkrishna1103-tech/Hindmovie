package hc;

import android.view.View;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6034u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ MainActivity f6035v;

    public /* synthetic */ e(MainActivity mainActivity, int i) {
        this.f6034u = i;
        this.f6035v = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f6034u;
        MainActivity mainActivity = this.f6035v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((DrawerLayout) mainActivity.W.f1739d).r();
                break;
            case 1:
                int i10 = MainActivity.F0;
                mainActivity.x();
                break;
            default:
                int i11 = MainActivity.F0;
                c7.h hVar = mainActivity.Y;
                if (hVar != null) {
                    ((LinearLayout) hVar.f2546c).setVisibility(8);
                    ga.b.p(mainActivity, qc.a.b("fMV0jMC6Nl9dg29dgBHhL29x"), new d(mainActivity, 7));
                    break;
                }
                break;
        }
    }
}
