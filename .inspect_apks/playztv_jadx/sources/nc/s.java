package nc;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.playz.tv.activities.PlayerActivity;
import java.util.ArrayList;
import n.z1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class s extends androidx.fragment.app.v {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public kc.c f8967r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f8968s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f8969t0;

    @Override // androidx.fragment.app.v
    public final void D() {
        this.f8967r0.f7627e.setAdapter((SpinnerAdapter) new ArrayAdapter(j(), gc.k.dropdown_item, new String[]{"ClearKey", "Widevine", "PlayReady"}));
        this.f8968s0 = 7;
        this.f8967r0.f7632l.setAdapter((SpinnerAdapter) new ArrayAdapter(j(), gc.k.dropdown_item, uc.b.f12921a));
        this.f8967r0.f7632l.setOnItemSelectedListener(new z1(2, this));
        this.f8967r0.f7623a.setOnClickListener(new hc.b(2));
        final int i = 0;
        this.f8967r0.f7634n.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i;
                s sVar = this.f8966v;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i11 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i12 = sVar.f8969t0;
                                String string7 = i12 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? i12 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i11 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i11 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i11;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
        final int i10 = 1;
        this.f8967r0.f7625c.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i10;
                s sVar = this.f8966v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i11 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i12 = sVar.f8969t0;
                                String string7 = i12 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? i12 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i11 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i11 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i11;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
        final int i11 = 2;
        this.f8967r0.f7631k.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i11;
                s sVar = this.f8966v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i112 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i12 = sVar.f8969t0;
                                String string7 = i12 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? i12 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i112 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i112 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i112;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
        final int i12 = 3;
        this.f8967r0.f7629h.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i12;
                s sVar = this.f8966v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i112 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i122 = sVar.f8969t0;
                                String string7 = i122 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i122 != 1 ? i122 != 2 ? i122 != 3 ? i122 != 4 ? i122 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i112 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i112 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i112;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
        final int i13 = 4;
        this.f8967r0.f.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i13;
                s sVar = this.f8966v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i112 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i122 = sVar.f8969t0;
                                String string7 = i122 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i122 != 1 ? i122 != 2 ? i122 != 3 ? i122 != 4 ? i122 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i112 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i112 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i112;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
        final int i14 = 5;
        this.f8967r0.f7635o.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i14;
                s sVar = this.f8966v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i112 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i122 = sVar.f8969t0;
                                String string7 = i122 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i122 != 1 ? i122 != 2 ? i122 != 3 ? i122 != 4 ? i122 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i112 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i112 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i112;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
        final int i15 = 6;
        this.f8967r0.i.setOnClickListener(new View.OnClickListener(this) { // from class: nc.r

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ s f8966v;

            {
                this.f8966v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i15;
                s sVar = this.f8966v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        sVar.f8967r0.f7633m.setText(uc.b.i(sVar.H()));
                        break;
                    case 1:
                        sVar.f8967r0.f7624b.setText(uc.b.i(sVar.H()));
                        break;
                    case 2:
                        sVar.f8967r0.f7630j.setText(uc.b.i(sVar.H()));
                        break;
                    case 3:
                        sVar.f8967r0.f7628g.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        sVar.f8967r0.f7626d.setText(uc.b.i(sVar.H()));
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        sVar.f8967r0.f7636p.setText(uc.b.i(sVar.H()));
                        break;
                    default:
                        String string = sVar.f8967r0.f7633m.getText().toString();
                        int i112 = 0;
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = string.toLowerCase();
                            StringBuilder sb2 = new StringBuilder(string);
                            String string2 = sVar.f8967r0.f7626d.getText().toString();
                            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                                String[] strArrSplit = string.split("\\|");
                                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                                    string2 = (String) arrayListH.get(1);
                                }
                                sb2 = sb3;
                            }
                            String str = (String) sVar.f8967r0.f7627e.getSelectedItem();
                            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                                String[] strArrSplit2 = sb2.toString().split("\\|");
                                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                                StringBuilder sb4 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                                    str = (String) arrayListH2.get(1);
                                }
                                sb2 = sb4;
                            }
                            String string3 = sb2.toString();
                            if (string3.indexOf("|") + 1 >= string3.length()) {
                                sb2 = new StringBuilder(string3.split("\\|")[0]);
                            }
                            String string4 = sVar.f8967r0.f7624b.getText().toString();
                            if (!TextUtils.isEmpty(string4) && !lowerCase.contains("cookie=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("cookie=");
                                sb2.append(string4);
                            }
                            String string5 = sVar.f8967r0.f7630j.getText().toString();
                            if (!TextUtils.isEmpty(string5) && !lowerCase.contains("referer=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("referer=");
                                sb2.append(string5);
                            }
                            String string6 = sVar.f8967r0.f7628g.getText().toString();
                            if (!TextUtils.isEmpty(string6) && !lowerCase.contains("origin=")) {
                                sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                sb2.append("origin=");
                                sb2.append(string6);
                            }
                            if (!TextUtils.isEmpty((String) sVar.f8967r0.f7632l.getSelectedItem()) && !lowerCase.contains("user-agent=")) {
                                int i122 = sVar.f8969t0;
                                String string7 = i122 == sVar.f8968s0 ? sVar.f8967r0.f7636p.getText().toString() : i122 != 1 ? i122 != 2 ? i122 != 3 ? i122 != 4 ? i122 != 5 ? null : "Mozilla/5.0 (Series40; NokiaC3-00/08.71) Profile/MIDP-2.1 Configuration/CLDC-1.1 NokiaBrowser/8.0.3.2 (KHTML, like Gecko) Mobile Safari/525" : "Mozilla/5.0 (iPhone; CPU iPhone OS 17_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1" : "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko" : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36" : "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36";
                                if (string7 != null) {
                                    sb2.append(sb2.toString().contains("|") ? "&" : "|");
                                    sb2.append("User-Agent=");
                                    sb2.append(string7);
                                }
                            }
                            String string8 = sb2.toString();
                            if (TextUtils.isEmpty(string2)) {
                                string2 = null;
                            }
                            String lowerCase2 = str.toLowerCase();
                            lowerCase2.getClass();
                            if (lowerCase2.equals("widevine")) {
                                i112 = 1;
                            } else if (!lowerCase2.equals("clearkey")) {
                                i112 = 2;
                            }
                            oc.f fVar = new oc.f();
                            fVar.f9540u = null;
                            fVar.f9541v = string8;
                            fVar.f9542w = string2;
                            fVar.f9543x = null;
                            fVar.f9544y = "pronull";
                            fVar.f9545z = i112;
                            fVar.A = true;
                            Intent intent = new Intent(sVar.H(), (Class<?>) PlayerActivity.class);
                            intent.putExtra("links_model", fVar);
                            sVar.G().startActivity(intent);
                        } else {
                            Toast.makeText(sVar.j(), "Please enter Stream Url first!", 0).show();
                        }
                        break;
                }
            }
        });
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_ns, (ViewGroup) null, false);
        int i = gc.j.cookie;
        TextInputEditText textInputEditText = (TextInputEditText) z7.a.k(viewInflate, i);
        if (textInputEditText != null) {
            i = gc.j.cookie_container;
            TextInputLayout textInputLayout = (TextInputLayout) z7.a.k(viewInflate, i);
            if (textInputLayout != null) {
                i = gc.j.drm;
                TextInputEditText textInputEditText2 = (TextInputEditText) z7.a.k(viewInflate, i);
                if (textInputEditText2 != null) {
                    i = gc.j.drm_button;
                    Spinner spinner = (Spinner) z7.a.k(viewInflate, i);
                    if (spinner != null) {
                        i = gc.j.drm_container;
                        TextInputLayout textInputLayout2 = (TextInputLayout) z7.a.k(viewInflate, i);
                        if (textInputLayout2 != null) {
                            i = gc.j.origin;
                            TextInputEditText textInputEditText3 = (TextInputEditText) z7.a.k(viewInflate, i);
                            if (textInputEditText3 != null) {
                                i = gc.j.origin_container;
                                TextInputLayout textInputLayout3 = (TextInputLayout) z7.a.k(viewInflate, i);
                                if (textInputLayout3 != null) {
                                    i = gc.j.play;
                                    FloatingActionButton floatingActionButton = (FloatingActionButton) z7.a.k(viewInflate, i);
                                    if (floatingActionButton != null) {
                                        i = gc.j.referer;
                                        TextInputEditText textInputEditText4 = (TextInputEditText) z7.a.k(viewInflate, i);
                                        if (textInputEditText4 != null) {
                                            i = gc.j.referer_container;
                                            TextInputLayout textInputLayout4 = (TextInputLayout) z7.a.k(viewInflate, i);
                                            if (textInputLayout4 != null) {
                                                i = gc.j.ua_button;
                                                Spinner spinner2 = (Spinner) z7.a.k(viewInflate, i);
                                                if (spinner2 != null) {
                                                    i = gc.j.url;
                                                    TextInputEditText textInputEditText5 = (TextInputEditText) z7.a.k(viewInflate, i);
                                                    if (textInputEditText5 != null) {
                                                        i = gc.j.url_container;
                                                        TextInputLayout textInputLayout5 = (TextInputLayout) z7.a.k(viewInflate, i);
                                                        if (textInputLayout5 != null) {
                                                            i = gc.j.user_agent_container;
                                                            TextInputLayout textInputLayout6 = (TextInputLayout) z7.a.k(viewInflate, i);
                                                            if (textInputLayout6 != null) {
                                                                i = gc.j.user_agent_txt;
                                                                TextInputEditText textInputEditText6 = (TextInputEditText) z7.a.k(viewInflate, i);
                                                                if (textInputEditText6 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                                                    this.f8967r0 = new kc.c(constraintLayout, textInputEditText, textInputLayout, textInputEditText2, spinner, textInputLayout2, textInputEditText3, textInputLayout3, floatingActionButton, textInputEditText4, textInputLayout4, spinner2, textInputEditText5, textInputLayout5, textInputLayout6, textInputEditText6);
                                                                    return constraintLayout;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
