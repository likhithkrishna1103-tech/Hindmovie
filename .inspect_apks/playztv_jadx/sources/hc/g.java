package hc;

import a2.h0;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.TvActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6038v;

    public /* synthetic */ g(int i, Object obj) {
        this.f6037u = i;
        this.f6038v = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i10 = this.f6037u;
        Object obj = this.f6038v;
        switch (i10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i11 = MainActivity.F0;
                ((MainActivity) obj).finish();
                break;
            case 1:
                int i12 = TvActivity.f3654x0;
                ((TvActivity) obj).finish();
                break;
            case 2:
                h0 h0Var = (h0) obj;
                ic.u uVar = (ic.u) h0Var.f255v;
                oc.h hVar = (oc.h) h0Var.f256w;
                int i13 = h0Var.f254u;
                Context context = uVar.f6561d;
                String str = hVar.f9554a;
                String str2 = hVar.f9555b;
                String str3 = hVar.f9556c;
                String str4 = hVar.f9557d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("*");
                sb2.append(str2);
                sb2.append("*");
                sb2.append(str3);
                String strO = l4.a.o(sb2, "*", str4);
                Set<String> stringSet = uc.b.f(context).getStringSet("list", new HashSet());
                HashSet hashSet = new HashSet();
                for (String str5 : stringSet) {
                    if (!str5.equals(strO)) {
                        hashSet.add(str5);
                    }
                }
                context.getSharedPreferences("DataPreferences", 0).edit().putStringSet("list", hashSet).apply();
                uVar.f.remove(i13);
                uVar.f6562e.f1349a.f8973t0 = new ArrayList(uVar.f);
                uVar.f10982a.e(i13);
                break;
            case 3:
                ((Activity) obj).finish();
                break;
            default:
                ((Activity) ((Context) obj)).finish();
                break;
        }
    }
}
