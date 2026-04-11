package r5;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10859v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10860w;

    public /* synthetic */ e(MainActivity mainActivity, int i) {
        this.f10859v = i;
        this.f10860w = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f10859v;
        MainActivity mainActivity = this.f10860w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((DrawerLayout) mainActivity.X.f2038e).r();
                break;
            default:
                int i10 = MainActivity.B0;
                mainActivity.x();
                break;
        }
    }
}
