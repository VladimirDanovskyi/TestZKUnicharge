package demoZK.mvm;

import demoZK.model.Report;
import demoZK.model.SaleData;
import demoZK.services.MyService;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
@Component
public class MyViewModel {
	@WireVariable
	private MyService myService;
	private Report report=null;

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	private SaleData saleData=new SaleData();

	public SaleData getSaleData() {
		return saleData;
	}

	public void setSaleData(SaleData saleData) {
		this.saleData = saleData;
	}
	/**
	 * Created by Admin on 23.05.2017.
	 */


	@Command
	@NotifyChange("report")
	public void submit() {
    report =new Report();
		 report=myService.isSaleSuccesfull(saleData);

		if(report.getIsSuccsessfull()){
			Window window = (Window) Executions.createComponents(
					"/widgets/window/modal_dialog/saccessfull.zul", null, null);
			window.doModal();

		}else{
			report=myService.isSaleSuccesfull(saleData);
			System.out.println(report.getResponse());

		}
	}


}
