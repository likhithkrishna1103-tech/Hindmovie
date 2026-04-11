package t7;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12325u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Intent f12326v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f12327w;

    public /* synthetic */ o(Intent intent, Object obj, int i) {
        this.f12325u = i;
        this.f12326v = intent;
        this.f12327w = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, s7.f] */
    public final void a() {
        switch (this.f12325u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Intent intent = this.f12326v;
                if (intent != null) {
                    ((GoogleApiActivity) this.f12327w).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.f12326v;
                if (intent2 != null) {
                    this.f12327w.a(intent2, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e10) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e10);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
