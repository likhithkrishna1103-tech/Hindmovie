package r5;

import android.widget.CompoundButton;
import android.widget.Spinner;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.TvActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l7.a f10864b;

    public /* synthetic */ g(l7.a aVar, int i) {
        this.f10863a = i;
        this.f10864b = aVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int i = this.f10863a;
        l7.a aVar = this.f10864b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i10 = MainActivity.B0;
                if (!z10) {
                    Spinner spinner = (Spinner) aVar.f7868y;
                    spinner.setAlpha(0.5f);
                    spinner.setEnabled(false);
                    spinner.setClickable(false);
                } else {
                    Spinner spinner2 = (Spinner) aVar.f7868y;
                    spinner2.setAlpha(1.0f);
                    spinner2.setEnabled(true);
                    spinner2.setClickable(true);
                }
                break;
            default:
                int i11 = TvActivity.f1550s0;
                if (!z10) {
                    Spinner spinner3 = (Spinner) aVar.f7868y;
                    spinner3.setAlpha(0.5f);
                    spinner3.setEnabled(false);
                    spinner3.setClickable(false);
                } else {
                    Spinner spinner4 = (Spinner) aVar.f7868y;
                    spinner4.setAlpha(1.0f);
                    spinner4.setEnabled(true);
                    spinner4.setClickable(true);
                }
                break;
        }
    }
}
