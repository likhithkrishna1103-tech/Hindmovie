package ic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends x0 {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final LottieAnimationView D;
    public final TextView E;
    public int F;
    public final /* synthetic */ k G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MaterialCardView f6515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f6516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f6517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f6518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f6519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f6520z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, View view) {
        super(view);
        this.G = kVar;
        this.f6515u = (MaterialCardView) view.findViewById(gc.j.event_card);
        this.f6519y = (TextView) view.findViewById(gc.j.teamAName);
        this.f6520z = (TextView) view.findViewById(gc.j.teamBName);
        this.f6517w = (ImageView) view.findViewById(gc.j.teamAFlag);
        this.f6518x = (ImageView) view.findViewById(gc.j.teamBFlag);
        this.f6516v = (ImageView) view.findViewById(gc.j.event_logo);
        this.C = (TextView) view.findViewById(gc.j.event_text);
        this.A = (TextView) view.findViewById(gc.j.date_text);
        this.B = (TextView) view.findViewById(gc.j.time_text);
        this.E = (TextView) view.findViewById(gc.j.status_text);
        this.D = (LottieAnimationView) view.findViewById(gc.j.live_anim_view);
    }

    public final void q(oc.e eVar) {
        String str;
        String str2 = eVar.f9533j + "|" + eVar.i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
        SimpleDateFormat simpleDateFormatC = uc.b.c("dd/MM/yyyy|HH:mm:ss");
        try {
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            str = simpleDateFormat.format(simpleDateFormatC.parse(str2));
        } catch (ParseException unused) {
            str = null;
        }
        String[] strArrSplit = str.split("\\|");
        String[] strArrSplit2 = strArrSplit[1].split("\\s+")[0].split(":");
        int i = Integer.parseInt(strArrSplit2[0]);
        int i10 = Integer.parseInt(strArrSplit2[1]);
        String str3 = i < 12 ? " AM" : " PM";
        int i11 = i % 12;
        int i12 = i11 != 0 ? i11 : 12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12 < 10 ? e6.j.l("0", i12) : Integer.valueOf(i12));
        sb2.append(":");
        sb2.append(i10 < 10 ? e6.j.l("0", i10) : Integer.valueOf(i10));
        sb2.append(str3);
        String string = sb2.toString();
        TextView textView = this.B;
        textView.setText(string);
        String str4 = strArrSplit[0];
        TextView textView2 = this.A;
        textView2.setText(str4);
        textView2.setVisibility(0);
        textView.setVisibility(0);
        this.D.setVisibility(8);
    }
}
