package lc;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends Dialog {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f8102u;

    public j(Context context, String str) {
        super(context);
        this.f8102u = str;
    }

    public static void a(Context context, String str) {
        if (!context.getSharedPreferences("DataPreferences", 0).getBoolean("tg_dialog", true) || context.getSharedPreferences("DataPreferences", 0).getBoolean("is_tv", false)) {
            return;
        }
        j jVar = new j(context, str);
        jVar.setCancelable(true);
        jVar.setCanceledOnTouchOutside(false);
        Window window = jVar.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        jVar.show();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(gc.k.dialog_telegram, (ViewGroup) null, false);
        int i = gc.j.card_view;
        if (((MaterialCardView) z7.a.k(viewInflate, i)) != null) {
            i = gc.j.donot_show_btn;
            Button button = (Button) z7.a.k(viewInflate, i);
            if (button != null) {
                i = gc.j.join_tg_btn;
                Button button2 = (Button) z7.a.k(viewInflate, i);
                if (button2 != null) {
                    i = gc.j.later_btn;
                    Button button3 = (Button) z7.a.k(viewInflate, i);
                    if (button3 != null) {
                        setContentView((RelativeLayout) viewInflate);
                        final int i10 = 0;
                        button3.setOnClickListener(new View.OnClickListener(this) { // from class: lc.i

                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                            public final /* synthetic */ j f8101v;

                            {
                                this.f8101v = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i10) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        this.f8101v.dismiss();
                                        break;
                                    case 1:
                                        j jVar = this.f8101v;
                                        jVar.getClass();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse(jVar.f8102u));
                                            jVar.getContext().startActivity(intent);
                                            jVar.dismiss();
                                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                                            Toast.makeText(jVar.getContext(), "Telegram not installed", 0).show();
                                            return;
                                        }
                                        break;
                                    default:
                                        j jVar2 = this.f8101v;
                                        uc.b.g(jVar2.getContext()).putBoolean("tg_dialog", false).apply();
                                        jVar2.dismiss();
                                        break;
                                }
                            }
                        });
                        final int i11 = 1;
                        button2.setOnClickListener(new View.OnClickListener(this) { // from class: lc.i

                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                            public final /* synthetic */ j f8101v;

                            {
                                this.f8101v = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i11) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        this.f8101v.dismiss();
                                        break;
                                    case 1:
                                        j jVar = this.f8101v;
                                        jVar.getClass();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse(jVar.f8102u));
                                            jVar.getContext().startActivity(intent);
                                            jVar.dismiss();
                                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                                            Toast.makeText(jVar.getContext(), "Telegram not installed", 0).show();
                                            return;
                                        }
                                        break;
                                    default:
                                        j jVar2 = this.f8101v;
                                        uc.b.g(jVar2.getContext()).putBoolean("tg_dialog", false).apply();
                                        jVar2.dismiss();
                                        break;
                                }
                            }
                        });
                        final int i12 = 2;
                        button.setOnClickListener(new View.OnClickListener(this) { // from class: lc.i

                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                            public final /* synthetic */ j f8101v;

                            {
                                this.f8101v = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i12) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        this.f8101v.dismiss();
                                        break;
                                    case 1:
                                        j jVar = this.f8101v;
                                        jVar.getClass();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse(jVar.f8102u));
                                            jVar.getContext().startActivity(intent);
                                            jVar.dismiss();
                                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                                            Toast.makeText(jVar.getContext(), "Telegram not installed", 0).show();
                                            return;
                                        }
                                        break;
                                    default:
                                        j jVar2 = this.f8101v;
                                        uc.b.g(jVar2.getContext()).putBoolean("tg_dialog", false).apply();
                                        jVar2.dismiss();
                                        break;
                                }
                            }
                        });
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
