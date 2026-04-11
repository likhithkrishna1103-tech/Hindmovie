package hc;

import android.content.DialogInterface;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.TvActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6041u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ kc.b f6042v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h.j f6043w;

    public /* synthetic */ i(h.j jVar, kc.b bVar, int i) {
        this.f6041u = i;
        this.f6043w = jVar;
        this.f6042v = bVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.f6041u;
        kc.b bVar = this.f6042v;
        h.j jVar = this.f6043w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                MainActivity mainActivity = (MainActivity) jVar;
                int i10 = MainActivity.F0;
                uc.b.f(mainActivity).edit().putInt("floatings", (((Switch) bVar.f7621w).isChecked() ? ((Spinner) bVar.f7622x).getSelectedItemPosition() : -1) + 1).apply();
                break;
            default:
                TvActivity tvActivity = (TvActivity) jVar;
                int i11 = TvActivity.f3654x0;
                uc.b.f(tvActivity).edit().putInt("floatings", (((Switch) bVar.f7621w).isChecked() ? ((Spinner) bVar.f7622x).getSelectedItemPosition() : -1) + 1).apply();
                break;
        }
    }
}
