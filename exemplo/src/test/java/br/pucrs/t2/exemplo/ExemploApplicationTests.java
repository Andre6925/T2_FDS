package br.pucrs.t2.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.pucrs.t2.exemplo.Adapters.Controllers.ACMEController;
import br.pucrs.t2.exemplo.Aplication.Dtos.CompradorDTO;
import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Aplication.Usecases.comprador.AddCompradorUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.comprador.ListCompradoresUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.comprador.ListComprasDeCompradorUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.comprador.UpdateCompradorUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.fornecedor.ListFornecedoresUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia.AddTecnolgiaUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia.FindTecnologiaByIdUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia.ListTecnologiaDeFornecedorUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia.ListTecnologiaUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.venda.AddVendaUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.venda.FindVendaByNumUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.venda.GetValorFinalVendaUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.venda.ListVendasUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.venda.RemoveVendaLogicaUC;
import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Services.CalculadoraVendaService;
import br.pucrs.t2.exemplo.Infra.CompradorRepoMemo;
import br.pucrs.t2.exemplo.Infra.FornecedorRepoMemo;
import br.pucrs.t2.exemplo.Infra.TecnologiaRepoMemo;
import br.pucrs.t2.exemplo.Infra.VendaRepoMemo;

@SpringBootTest
class ExemploApplicationTests {

	private CompradorRepoMemo compradorRepo;
    private FornecedorRepoMemo fornecedorRepo;
    private TecnologiaRepoMemo tecnologiaRepo;
    private VendaRepoMemo vendaRepo;

    private ACMEController controller;

    @BeforeEach
    void setup() {

        compradorRepo = new CompradorRepoMemo();
        fornecedorRepo = new FornecedorRepoMemo();
        tecnologiaRepo = new TecnologiaRepoMemo(fornecedorRepo);
        vendaRepo = new VendaRepoMemo(tecnologiaRepo, compradorRepo);

        compradorRepo.initData();
        fornecedorRepo.initData();
        tecnologiaRepo.initData();
        vendaRepo.initData();

        controller = new ACMEController(
            new FindTecnologiaByIdUC(tecnologiaRepo),
            new ListTecnologiaUC(tecnologiaRepo),
            new AddTecnolgiaUC(tecnologiaRepo, fornecedorRepo),
            new ListFornecedoresUC(fornecedorRepo),
            new AddCompradorUC(compradorRepo),
            new ListCompradoresUC(compradorRepo),
            new UpdateCompradorUC(compradorRepo),
            new AddVendaUC(vendaRepo, tecnologiaRepo, compradorRepo),
            new FindVendaByNumUC(vendaRepo),
            new ListVendasUC(vendaRepo),
            new GetValorFinalVendaUC(vendaRepo, new CalculadoraVendaService()),
            new ListComprasDeCompradorUC(vendaRepo),
            new ListTecnologiaDeFornecedorUC(tecnologiaRepo),
            new RemoveVendaLogicaUC(vendaRepo)
        );
    }

    @Test
    void testMensagem() {
        assertEquals("Bem-vindo", controller.mensagem());
    }

    @Test
    void testListFornecedores() {
        var lista = controller.getFornecedores();
        assertEquals(4, lista.size());
    }

    @Test
    void testListCompradores() {
        var lista = controller.getCompradores();
        assertEquals(3, lista.size());
    }

    @Test
    void testListTecnologias() {
        var lista = controller.getTecnologias();
        assertEquals(3, lista.size());
    }

    @Test
    void testGetTecnologiaById() {
        var response = controller.getTecnologiaById(1);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    void testAddComprador() {
        CompradorDTO dto = new CompradorDTO(100, "Pedro", "Brasil", "pedro@gmail.com");
        boolean ok = controller.addComprador(dto);
        assertTrue(ok);
        assertEquals(4, controller.getCompradores().size());
    }

    @Test
    void testUpdateComprador() {
        CompradorDTO dto = new CompradorDTO(1, "Carlos Atualizado", "Chile", "novo@email");
        boolean ok = controller.alterarComprador(dto);
        assertTrue(ok);
        var compradores = controller.getCompradores();
        var c = compradores.stream().filter(x -> x.getCod()==1).findFirst().get();
        assertEquals("Carlos Atualizado", c.getNome());
    }

    @Test
    void testAddTecnologia() {
        TecnologiaDTO dto = new TecnologiaDTO(
                999, "Modelo X", "Desc", 2000, 2.5, 70, 1L, "TechCorp"
        );
        boolean ok = controller.addTecnologia(dto);
        assertTrue(ok);
        assertEquals(4, controller.getTecnologias().size());
    }

    @Test
    void testGetVendas() {
        var lista = controller.getVendas();
        assertEquals(2, lista.size());
    }

    @Test
    void testAddVenda() {
        VendaDTO dto = new VendaDTO(888, 1, null, 1, null, false);
        boolean ok = controller.addVenda(dto);
        assertTrue(ok);
        var vendas = controller.getVendas();
        assertEquals(3, vendas.size());
    }

    @Test
    void testRemoveVenda() {
        boolean ok = controller.removerVenda(1001);
        assertTrue(ok);
        var v = controller.getVendas()
                .stream()
                .filter(x -> x.getNum() == 1001)
                .findFirst()
                .get();
        assertTrue(v.isRemovida());
    }

    @Test
    void testListComprasDeComprador() {
        var lista = controller.getComprasDeComprador(1);
        assertEquals(1, lista.size());
        assertEquals(1001, lista.get(0).getNum());
    }

	@Test
    void testCalculoValorFinal() {
        Fornecedor f = new Fornecedor(1L, "TechCorp", Date.valueOf("2020-01-01"), AreaFornecedor.TI);
        Tecnologia t = new Tecnologia(10, "Modelo", "Desc", 1000, 1.0, 20, f);
        Comprador c = new Comprador(2L, "João", "Brasil", "email");
        Venda v = new Venda(100, t, c, false);

        CalculadoraVendaService calc = new CalculadoraVendaService();
        double result = calc.calcularValorFinal(v, 5); // 5% desconto
        // Valor base = 1000
        // TI = +20%
        // 1000 * 1.20 = 1200
        // desconto 5% = 1200 * 0.95 = 1140
        assertEquals(1140, result, 0.0001);
    }

	@Test
    void testGettersSetters() {
        Fornecedor f = new Fornecedor(1L, "Forn", Date.valueOf("2020-01-01"), AreaFornecedor.TI);
        Tecnologia t = new Tecnologia(5, "A", "B", 100, 2.0, 30, f);
        assertEquals(5, t.getId());
        assertEquals("A", t.getModelo());
        assertEquals("B", t.getDescricao());
        assertEquals(100, t.getValorBase());
        assertEquals(2.0, t.getPeso());
        assertEquals(30, t.getTemperatura());
        assertEquals(f, t.getFornecedor());
    }
}


