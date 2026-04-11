package hc;

import android.widget.CompoundButton;
import android.widget.Spinner;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.chip.Chip;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.TvActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6040b;

    public /* synthetic */ h(int i, Object obj) {
        this.f6039a = i;
        this.f6040b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        int i = this.f6039a;
        Object obj = this.f6040b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                kc.b bVar = (kc.b) obj;
                int i10 = MainActivity.F0;
                if (!z2) {
                    Spinner spinner = (Spinner) bVar.f7622x;
                    spinner.setAlpha(0.5f);
                    spinner.setEnabled(false);
                    spinner.setClickable(false);
                } else {
                    Spinner spinner2 = (Spinner) bVar.f7622x;
                    spinner2.setAlpha(1.0f);
                    spinner2.setEnabled(true);
                    spinner2.setClickable(true);
                }
                break;
            case 1:
                kc.b bVar2 = (kc.b) obj;
                int i11 = TvActivity.f3654x0;
                if (!z2) {
                    Spinner spinner3 = (Spinner) bVar2.f7622x;
                    spinner3.setAlpha(0.5f);
                    spinner3.setEnabled(false);
                    spinner3.setClickable(false);
                } else {
                    Spinner spinner4 = (Spinner) bVar2.f7622x;
                    spinner4.setAlpha(1.0f);
                    spinner4.setEnabled(true);
                    spinner4.setClickable(true);
                }
                break;
            default:
                Chip chip = (Chip) obj;
                j9.g gVar = chip.D;
                if (gVar != null) {
                    j9.a aVar = (j9.a) ((u5.c) gVar).f12782v;
                    if (!z2 ? aVar.e(chip, aVar.f6835e) : aVar.a(chip)) {
                        aVar.d();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.C;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z2);
                }
                break;
        }
    }
}
